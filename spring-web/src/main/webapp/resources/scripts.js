$(document).ready(function() {
   
    $("#contactNumber").on("click",".delete", function(){ 
        $(this).parent('div').remove();
    });

    $("#email").click(function(){ 
            $("#contactNumber").append('<div><input type="hidden" name="contactType" value="Email"/>E-mail: ' +
                                       '<input type="text" name="contactInfo"/>'+
                                       '<button class="delete">Remove</button></div>');
    });
   
    $("#mobile").click(function(){ 
            $("#contactNumber").append('<div id="hey"><input type="hidden" name="contactType" value="Mobile"/>Mobile: '+
                                       '<input type="text" name="contactInfo"/>'+
                                       '<button class="delete">Remove</button></div>');
    });

    $("#landline").click(function(){ 
            $("#contactNumber").append('<div id="hey"><input type="hidden" name="contactType" value="Landline"/>Landline: '+
                                       '<input type="text" name="contactInfo"/>'+
                                       '<button class="delete">Remove</button></div>');
    });

    $("#search").click(function(event){
      var role = $("#role").val();
      var column = $("#column").val();
      var order = $("#order").val();
      
      $.ajax({
        url: "/",
        dataType: "json",
        data:{
            "role": role,
            "column": column,
            "order": order
        },

        success:function(persons){
          $("#table").children().remove();
          $.each(persons, function(i, person){
            $("#table").append("<tr><td>" + person.id + "</td>" + 
              "<td>" + person.firstName + " " + person.lastName + "</td>" +
              "<td>" + new Date(person.birthday).toISOString().slice(0,10) + "</td>" +
              "<td>" + person.gwa + "</td>" +
              "<td><form method=\"POST\"><input type=\"hidden\" name=\"id\" value=\""+person.id+"\"/><input type=\"submit\" value=\"Delete\"/></form>"+
              "<button onclick=\"location.href=\'/person/edit/" + person.id + "\'\">Edit</button></td></tr>");
          });
        },
        error:function(){
            console.log("error");
        },
      });
      event.preventDefault();
    });

    $("#roleSearch").click(function(event){
      var column = $("#column").val();
      var order = $("#order").val();
      $.ajax({
        url: "/role",
        dataType: "json",
        data:{
            "column": column,
            "order": order
        },

        success:function(roles){
          $("#roleTable").children().remove();
          $.each(roles, function(i, role){
            $("#roleTable").append("<tr><td>" + role.roleId + "</td>" +
              "<td>" + role.roleType + "</td>" +
              "<td><form method=\"POST\"><input type=\"hidden\" name=\"id\" value=\"" + role.roleId + "\"/><input type=\"submit\" value=\"Delete\"/></form>"+
              "<button onclick=\"location.href=\'/role/edit/" + role.roleId + "\'\">Edit</button></td></tr>");
          });
        },
        error:function(){ console.log("error") 
        },
      });
      event.preventDefault();
    });

});