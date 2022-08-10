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
    <title>Add State</title>
</head>
<body style="margin: 100px; font-family: 'Segoe UI'">
<h4 style="text-align: center">State Master</h4>
<form id="saveState" action="/saveState" method="post">
    <div style="margin: auto" class="form-group col-md-8">

        <div class="form-group row required">

            <div class="col-md-4">
                <label class="form-label control-label" >Select Country</label>
                <select name="inputCountry" id="inputCountry" class="form-control lab" onchange="findDistrictByStateId(this.value)" required="required">
                    <option value="0">Select</option>
                    <c:forEach items="${countryList}" var="countryList">
                        <option value="${countryList.cid}">${countryList.cname}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-4">
                <label class="form-label control-label" >Country Name</label>
                <input type="text" class="form-control" id="inputState" name="inputState"  placeholder="Enter State Name"/>
                <div id="alert"></div>
            </div>

            <input type="hidden" name="inputId"/>
        </div>

        <div style="margin-left:25px; margin-top: 20px" class="form-group row col-md-6">

            <div class="form-group row col-md-3">
                <button id="submit"   class="btn btn-success">Submit</button>
            </div>

            <div style="margin-left: 10px" class="form-group row col-md-3">
                <button onclick="window.location='home.jsp'; return false;" class="btn btn-danger">Cancel</button>
            </div>

        </div>

    </div>
</form>

<div style="margin: 8rem">
    <h4 style="text-align: center">All State Details</h4>

    <table id="qualificationTable table" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Sl No</th>
            <th>State Name</th>
            <th>Country Name</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${stateList}" var="stateList" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td>${stateList.sname}</td>
                <td>${stateList.country.cname}</td>
                <td>
                    <a href = "/editState/${stateList.sid}">Edit</a>
                    |
                    <a href = "/deleteState/${stateList.sid}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

<script>
    $(document).ready(function (){
        $('.table').DataTable();
    });
</script>
</body>
</html>
