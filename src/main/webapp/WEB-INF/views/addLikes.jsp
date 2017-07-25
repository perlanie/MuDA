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
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MuDA</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css'>
<link href="https://fonts.googleapis.com/css?family=Work+Sans:200"
	rel="stylesheet">
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.1/css/selectize.min.css '>

<spring:url value="/resources/css/selectize.default.css" var="selectize" />
<spring:url value="/resources/css/style.css" var="stylecss" />

<link href="${stylecss}" rel="stylesheet" />
<link href="${selectize}" rel="stylesheet" />

<spring:url value="/resources/js/selectize.js" var="selectJs" />
<spring:url value="/resources/js/index.js" var="indexJs" />
</head>

<body>
	<div class="wrapper">
		<div class="header">
			<jsp:include page="/resources/components/menu.jsp" />
			<div class="contentbody">
				<br>
				<br>
				<br>
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<h2>Enter your other favourites</h2>
						<form method="post" action="addLikes">
							<select name="select" class="select" id="select"
								placeholder="Select">
								<option value="Kendrick Lamar">Kendrick Lamar</option>
								<option value="Kanye West">Kanye West</option>
								<option value="J. Cole">J. Cole</option>
								<option value="Eminem">Eminem</option>
							</select>
							<input type="submit" value="Get Recommendations" class="buttonnext"></input>
						</form>
						
					</div>
				</div>
			</div>
			<jsp:include page="/resources/components/footer.jsp" />
		</div>
	</div>
	<div class="background"></div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.1/js/standalone/selectize.min.js'></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

	<script src="${selectJs}"></script>
	<script src="${indexJs}"></script>
</body>
</html>
