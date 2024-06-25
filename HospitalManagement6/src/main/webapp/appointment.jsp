<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APPOINTMENT FORM</title>
    <link rel="stylesheet" href="appointment.css">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
</head>
<body>
    <h1 style="text-align: center; color: blueviolet;">Appointment Form</h1>
    <div class="mainform">
        <div class="subform">
          <form action="registerservlet" method="post">
            <div class="form">
              <label for="name" class="label"> Full Name </label>
              <input type="text" name="name" id="name" placeholder="Full Name" class="formbold-form-input" required/>
            </div>
           <div class="form">
              <label for="phone" class="label"> Phone Number </label>
              <input type="text" name="phone" id="phone" placeholder="Enter your phone number" class="formbold-form-input" required/>
            </div> 
            <div class="form">
              <label for="email" class="label"> Email Address </label>
              <input type="email" name="email" id="email" placeholder="Enter your email" class="formbold-form-input" required/>
            </div>
           <div class="mform">
              <div class="pform">
                <div class="forml">
                  <label for="date" class="label"> Date </label>
                  <input type="date" name="date" id="date"  class="formbold-form-input" required/>
                </div>
              </div>
              <div class="pform">
                <div class="form">
                  <label for="time" class="label"> Time </label>
                  <input type="time" name="time" id="time" class="formbold-form-input" required/>
                </div>
              </div>
            </div> 
      
            <div class="formx">
              <label class="labelx">
                Address Details
              </label>
              <div class="mform">
                <div class="pform">
                  <div class="form">
                    <input type="text"  name="area" id="area" placeholder="Enter area" class="formbold-form-input" required/>
                  </div>
                </div>
                <div class="pform">
                  <div class="form">
                    <input type="text" name="city" id="city" placeholder="Enter city" class="formbold-form-input" required/>
                  </div>
                </div>
                <div class="pform">
                  <div class="form">
                    <input type="text" name="state"id="state" placeholder="Enter state" class="formbold-form-input" required/>
                  </div>
                </div>
                <div class="pform">
                  <div class="form">
                    <input type="text" name="post-code"id="post_code"placeholder="Post Code"class="formbold-form-input"/>
                  </div> 
                </div>  
              </div>
            </div>
            
            <div>
              <button class="fbutton">Book Appointment</button>
            </div>
          </form>
        </div>
      </div>




      <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

      <script>
        AOS.init();
      </script>
</body>
</html>