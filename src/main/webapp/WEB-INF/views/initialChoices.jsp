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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Muda | Music Data Mining Algorithm</title>
<link href="https://fonts.googleapis.com/css?family=Work+Sans:200"
	rel="stylesheet">

<spring:url value="/resources/css/logincss.css" var="mudacss" />
<spring:url value="/resources/css/style.css" var="mudacss2" />
<spring:url value="/resources/css/selection.css" var="mudacss3" />
<spring:url value="/resources/js/select.js" var="mainJs" />

<link href="${mudacss2}" rel="stylesheet" />
<link href="${mudacss}" rel="stylesheet" />
<link href="${mudacss3}" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>

<body>
	<div class="wrapper">
		<div class="header">
			<jsp:include page="/resources/components/menu.jsp" />

			<div class="contentbody">
				<h1>Choose your favorite artists:</h1>
				<div class="selectflow">
					<form action="choose.html" method="get" modelAttribute="user">
						<section class="buttonGroup">
						<h3>Choose One..</h3>
						<span><input class="buttonGroup-button" type=""
							data-buttonGroup="0" name="a0" value="Bon Iver"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="0" name="a0"
							value="Mac DeMarco"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="0" name="a0"
							value="Angel Olsen"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="0" name="a0"
							value="Sufjan Stevens"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="0" name="a0"
							value="None of these"></a></span>

						<h3>Choose Another...</h3>
						<span><input class="buttonGroup-button"
							data-buttonGroup="1" name="a2" value="Aesop Rock"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="1" name="a1"
							value="Madvillian"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="1" name="a1"
							value="Run the Jewels"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="1" name="a1"
							value="Childish Gambino"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="1" name="a1"
							value="None of these"></a></span>



						<h3>Last One...</h3>
						<span><input class="buttonGroup-button"
							data-buttonGroup="2" name="a2" value="Led Zepplin"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="2" name="a2"
							value="Pink Floyd"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="2" name="a2"
							value="The Police"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="2" name="a2"
							value="The Doors"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="2" name="a2"
							value="None of these"></a></span>


						<h3>Last Last One...</h3>
						<span><input class="buttonGroup-button"
							data-buttonGroup="3" name="a1" value="Lorde"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="3" name="a3"
							value="Sia"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="3" name="a3"
							value="Lana Del Rey"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="3" name="a3"
							value="Michael Jackson"></a></span> <span><input
							class="buttonGroup-button" data-buttonGroup="3" name="a3"
							value="None of these"></a></span> </section>
						<br>
						<button class="buttonnext">
							<a href="addLikes">Continue</a>
						</button>
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

	<script src="${mainJs}"></script>

</body>
</html>