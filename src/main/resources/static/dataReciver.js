$(document).ready(function(){


  $("#add_form").click(function(){

    console.log('weszlo');

    let nameForm = $('#name').val();
    let emailForm = $('#email').val();
    let messageForm = $('#message').val();

   var newData={
     name: nameForm,
     email: emailForm,
     message: messageForm,
   }

    $.ajax({
      url: 'http://localhost:8080/userFormPost',
      type: 'post',
      data: newData,
      success: function(data){
        $("#return_data").html("<b>Registered with success user " + data.userName + " , email "+ data.userEmail + " </b>");
        $('.contact-status').hide();

      }
    })
  })

})
