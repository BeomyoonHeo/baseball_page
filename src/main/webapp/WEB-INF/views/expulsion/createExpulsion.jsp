<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">퇴출 사유 등록 페이지 입니다.</h1>
<div class="container mt-3">
	<div class="input-group mt-3 mb-3" style="width: 1000px; left: 30%; width: 700px; left:20%; display: flex; justify-content: space-around;">
		<p>선수 이름 :</p>
		<select id="teamlist">
			<c:forEach var="player" items="${playerlist}">
				<option value="${player.id}">${player.name}</option>
			</c:forEach>
		</select><p> 퇴출 사유: </p><input id="reason" type="text" class="form-control" placeholder="사유입력">
		<button id="btnConfirm" class="btn btn-success" type="button">등록</button>
	</div>
</div>

<script src="/js/expulsion.js"></script>


<%@ include file="../layout/footer.jsp"%>