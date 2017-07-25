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
<spring:url value="/resources/css/logincss.css" var="loginCss" />
<spring:url value="/resources/css/style.css" var="styleCss" />
<spring:url value="/resources/css/selection.css" var="selectionCss" />
<spring:url value="/resources/js/select.js" var="selectJs" />

<link href="${loginCss}" rel="stylesheet" />
<link href="${styleCss}" rel="stylesheet" />
<link href="${selectionCss}" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>

<body>
	<div class="wrapper">
		<div class="header">
			<jsp:include page="/resources/components/menu.jsp" />

			<div class="contentbody">

				<h1>Artists you would like:</h1>
				<div class="selectflow">
					<form action="suggestion.html" method="get">
						<section class="buttonGroup"> 
							<span><a class="buttonGroup-button" data-buttonGroup="0" name="a1" value="{A1}">Cage the Elephant</a></span> 
							<span><a class="buttonGroup-button" data-buttonGroup="0" name="a1" value="{A1}">Mother Mother</a></span> 
							<span><div class="buttonGroup-button" data-buttonGroup="0" name="a1" value="{A1}">Ramones</div></span> 
							<span><div class="buttonGroup-button" data-buttonGroup="0" name="a1" value="{A1}">Timber Timbre</div></span> 
							<span><div class="buttonGroup-button" data-buttonGroup="0" name="a1" value="{A1}">Arctic Monkeys</div></span> 
						</section>
						<br>
						<button type="submit" class="buttonnext">More...</button>
					</form>
				</div>
			</div>


			<jsp:include page="/resources/components/footer.jsp" />
		</div>
	</div>

	<div class="background"></div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="${selectJs}"></script>

</body>
</html>