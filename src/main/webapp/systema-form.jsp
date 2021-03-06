    <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
		<head>
            <title>System Form</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>
<body>
         <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.easywayproducts.com" class="navbar-brand"> Easyway - Systems Inventory </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Systems</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${systema != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${systema == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${systema != null}">
                                    Edit System
                                </c:if>
                                <c:if test="${systema == null}">
                                    Add New System
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${systema != null}">
                            <input type="hidden" name="id" value="<c:out value='${systema.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>System Name</label> <input type="text" value="<c:out value='${systema.name}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>System Serial Number</label> <input type="text" value="<c:out value='${systema.serialNumber}' />" class="form-control" name="serialNumber">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>System Location</label> <input type="text" value="<c:out value='${systema.location}' />" class="form-control" name="location">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>