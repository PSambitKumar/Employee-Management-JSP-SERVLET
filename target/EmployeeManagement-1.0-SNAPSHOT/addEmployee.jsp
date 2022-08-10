<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Employee Master</title>
</head>
<body style="font-family: 'Segoe UI'; margin: 100px">
<h4 style="text-align: center">Employee Registration</h4>
<form id="saveEmployee" method="post" action="/saveEmployee">

    <div style="margin-left: 30px; margin-top: 30px" class="form-group col-md-12">

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Personal Details</legend>
            <div style="margin-top: 4rem" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" >Employee Name<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="inputName" name="inputName" <%--onblur="validateName()"--%>  placeholder="Enter Your Name"/>
                    <div id="name-alert"></div>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >Mobile Number<span style="color: red">*</span></label>
                    <input type="number" class="form-control" id="inputMobile" name="inputMobile"  placeholder="Enter Mobile Number"/>
                    <div id="mobile-alert"></div>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >Email Address<span style="color: red">*</span></label>
                    <input type="email" class="form-control" id="inputEmail" name="inputEmail"  placeholder="Enter Email Address"/>
                    <div id="email-alert"></div>
                </div>

            </div>

            <div style="margin-top: 20px" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" >Date of Birth<span style="color: red">*</span></label>
                    <input type="date" class="form-control" id="inputDob" name="inputDob"  placeholder="Select Date"/>
                    <div id="dob-alert"></div>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >Select Nationality<span style="color: red">*</span></label>
                    <select name="inputNationality" id="inputNationality" class="form-control lab" onchange="findStateByCountryId(this.value)" required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${countryList}" var="countryList">
                            <option value="${countryList.cid}">${countryList.cname}</option>
                        </c:forEach>
                    </select>
                    <div id="nation-alert"></div>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >Select Religion<span style="color: red">*</span></label>
                    <select name="inputReligion" id="inputReligion" class="form-control lab"  required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${religionList}" var="religionList">
                            <option value="${religionList.rid}">${religionList.rname}</option>
                        </c:forEach>
                    </select>
                    <div id="religion-alert"></div>
                </div>

            </div>


            <div style="margin-top: 20px" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" >Select Qualification<span style="color: red">*</span></label>
                    <select name="inputQualification" id="inputQualification" class="form-control lab"  required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${qualificationList}" var="qualificationList">
                            <option value="${qualificationList.qualId}">${qualificationList.qualName}</option>
                        </c:forEach>
                    </select>
                    <div id="qual-alert"></div>
                </div>


                <div style="margin-top: 30px" class="col-md-4">
                    <label class="form-label" >Select Gender<span style="color: red">*</span></label>
                    <input class="form-check-input" type="radio" name="inputGender" value="male">Male &emsp;
                    <input class="form-check-input" type="radio" name="inputGender" value="female">Female
                    <div id="gen-alert"></div>
                </div>


            </div>
        </fieldset>

        <fieldset class="form-group border p-3">
            <legend style="color: orangered" class="w-auto px-2">Permanent Address</legend>
            <div style="margin-top: 4rem" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" >Street<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="inputStreet" name="inputStreet"  placeholder="Enter Street"/>
                    <div id="street-alert"></div>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >City<span style="color: red">*</span></label>
                    <input type="text" class="form-control" id="inputCity" name="inputCity"  placeholder="Enter City"/>
                    <div id="city-alert"></div>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >Select Country<span style="color: red">*</span></label>
                    <select name="inputCountry" id="inputCountry" class="form-control lab" onchange="findStatetByCountryId(this.value)" required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${countryList}" var="countryList">
                            <option value="${countryList.cid}">${countryList.cname}</option>
                        </c:forEach>
                    </select>
                    <div id="country-alert"></div>
                </div>

            </div>

            <div style="margin-top: 20px" class="form-group row required">


                <div class="col-md-4">
                    <label class="form-label control-label" >Select State<span style="color: red">*</span></label>
                    <select name="inputState" id="inputState" class="form-control lab" required="required">
                        <option value="0">Select</option>
                        <c:forEach items="${stateList}" var="stateList">
                            <option value="${stateList.sid}">${stateList.sname}</option>
                        </c:forEach>
                    </select>
                    <div id="state-alert"></div>
                </div>


                <div class="col-md-4">
                    <label class="form-label" >Pincode<span style="color: red">*</span></label>
                    <input type="number" class="form-control" id="inputPin" name="inputPin"  placeholder="Enter Pin Code"/>
                    <div id="pin-alert"></div>
                </div>

            </div>

        </fieldset>
        <div><input type="hidden" name="inputId"/></div>

        <div style="margin: auto; margin-top: 20px" class="form-group row col-md-8">

            <div class="form-group row col-md-3">
                <button id="submit"   class="btn btn-success">Submit</button>
            </div>

            <div style="margin-left: 10px" class="form-group row col-md-3">
                <button type="reset" class="btn btn-danger">Reset</button>
            </div>

        </div>

        <div id="display"></div>

    </div>
</form>

<script>
    function validateName(){
        var name = $('#inputName').val();

        $.ajax({
            type: "GET",
            url: "/checkDuplicateData",
            data: {
                "name" : name
            },
            success: function (response){
                var value = response;
                if (value == "Found"){
                    // alert("Employee Name Already Present!!");
                    $('#name-alert').html("Employee Name Already Present!!").css('color', 'red');
                    $('#inputName').val("");
                    $('#inputName').css('border', '1px solid red');
                    $('#inputName').focus();
                }
            },
            error: function (response){}
        });
    }
</script>

</body>
</html>
