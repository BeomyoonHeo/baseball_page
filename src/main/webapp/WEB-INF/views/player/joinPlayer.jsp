<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">선수 등록 페이지 입니다.</h1>
<div class="container mt-3">
	<div class="input-group mt-3 mb-3" style="width: 1000px; left: 30%; width: 700px; left:20%; display: flex; justify-content: space-around;">
		<p>팀 이름 :</p>
		<select id="teamlist">
			<c:forEach var="team" items="${teamlist}">
				<option value="${team.id}">${team.name}</option>
			</c:forEach>
		</select><p> 선수이름: </p><input id="name" type="text" class="form-control" placeholder="이름입력">
		<p> 포지션 : </p><input id="position" type="text" class="form-control" placeholder="포지션입력">

		<button id="btnConfirm" class="btn btn-success" type="button">등록</button>
	</div>
</div>

<script src="/js/player.js"></script>


<%@ include file="../layout/footer.jsp"%>