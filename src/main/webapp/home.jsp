<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="style/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400&display=swap" rel="stylesheet">
    <meta charset="ISO-8859-1">
    <title>CSM: Home</title>

</head>
<body>
<div>
    <div class="home">WELCOME HOME</div>
    <div class="content">
        <div class="container1">
            <div class="ccontainer">
                <div class="a">Qualification Master</div>
                <div class="a1"><a href = "/addQualification"><button type="button" class="btn btn-primary">Add Qualification</button></a></div>
                <div class="a2"><a href = "/addQualification"><button class="btn btn-success">View Qualification</button></a></div>
            </div>
        </div>

        <div class="container2">
            <div class="ccontainer">
                <div class="a">Country Master</div>
                <div class="a1"><a href = "/addCountry"><button class="btn btn-primary">Add Country</button></a></div>
                <div class="a2"><a href = "/addCountry"><button class="btn btn-success">View Country</button></a></div>
            </div>
        </div>

        <div class="container3">
            <div class="ccontainer">
                <div class="a">State Master</div>
                <div class="a1"><a href = "/addState"><button class="btn btn-primary">Add State</button></a></div>
                <div class="a2"><a href = "/addState"><button class="btn btn-success">View State</button></a></div>
            </div>
        </div>

        <div class="container4">
            <div class="ccontainer">
                <div class="a">Religion Master</div>
                <div class="a1"><a href = "/addReligion"><button class="btn btn-primary">Add Religion</button></a></div>
                <div class="a2"><a href = "/addReligion"><button class="btn btn-success">View Religion</button></a></div>

            </div>
        </div>

    </div>
</div>

<div class="content">
    <div class="container5">
        <div class="ccontainer">
            <div class="a">Employee Registration</div>
            <div class="a1"><a href = "/addEmployee"><button type="button" class="btn btn-primary">Add Employee</button></a></div>
            <div class="a2"><a href = "/viewEmployee"><button class="btn btn-success">View Employee</button></a></div>
        </div>
    </div>
</div>

<div class="copyright">@Copyright CSM 2022-2023.</div>
</body>
</html>