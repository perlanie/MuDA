<%--
    JBoss, Home of Professional Open Source
    Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
    contributors by the @authors tag. See the copyright.txt in the
    distribution for a full listing of individual contributors.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Muda | Music Data Mining Algorithm</title>
<link href="https://fonts.googleapis.com/css?family=Work+Sans:200"
	rel="stylesheet">
<spring:url value="/resources/css/logincss.css" var="mudacss" />
<spring:url value="/resources/css/style.css" var="mudacss2" />

<link href="${mudacss}" rel="stylesheet" />
<link href="${mudacss2}" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>
<body>

	<div class="wrapper">
		<div class="header">
			<jsp:include page="/resources/components/menu.jsp" />
			<div class="contentbot">
				<div class="content">
					<h2>Register</h2>
					<br>
					<form method="post" action="register" modelAttribute="userRegister">
						<input type="text" name="firstName" placeholder="First Name"
							required="required" value="" /> <input type="text"
							name="lastName" placeholder="Last Name" required="required"
							value="" /> <input type="text" name="email" placeholder="E-Mail Or Username"
							required="required" value="" /> <input type="password"
							name="password" placeholder="Password" required="required"
							value="" />
						<!-- <input type="password" name="confirm" placeholder="Confirm Password" required="required" /> -->
						<button class="btn btn-primary btn-block btn-large" type="submit">Sign
							Up</button>
						<c:out value="${message}" />
					</form>
				</div>
			</div>
			<jsp:include page="/resources/components/footer.jsp" />
		</div>
	</div>

	<div class="background"></div>

</body>
</html>