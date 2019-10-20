/**
 * 
 */
function validate()
{ 
   if( document.registrationform.user_name.value == "" )
   {
     alert( "Please provide your userName!" );
     document.registrationform.user_name.focus() ;
     return false;
   }
   if( document.registrationform.first_name.value == "" )
   {
     alert( "Please provide your First Name!" );
     document.registrationform.first_name.focus() ;
     return false;
   }
   
   if( document.registrationform.last_name.value == "" )
   {
     alert( "Please provide your Last Name!" );
     document.registrationform.last_name.focus() ;
     return false;
   }
   
   
   if( document.registrationform.designation.value == "" )
   {
     alert( "Please provide your designation!" );
     document.registrationform.designation.focus() ;
     return false;
   }   
   
   
 var email = document.registrationform.email.value;
  atpos = email.indexOf("@");
  dotpos = email.lastIndexOf(".");
 if (email == "" || atpos < 1 || ( dotpos - atpos < 2 )) 
 {
     alert("Please enter correct email ID")
     document.registrationform.email.focus() ;
     return false;
 }
  if( document.registrationform.dob.value == "" )
   {
     alert( "Please provide your DOB!" );
     document.registrationform.dob.focus() ;
     return false;
   }
  if( document.registrationform.phone_number.value == "" ||
           isNaN( document.registrationform.phone_number.value) ||
           document.registrationform.phone_number.value.length != 10 )
   {
     alert( "Please provide a Mobile No in the format 123." );
     document.registrationform.phone_number.focus() ;
     return false;
   }
   return( true );
}
