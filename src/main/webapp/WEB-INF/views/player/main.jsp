<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">선수 목록 페이지 입니다.</h1>
<div class="container mt-3">
	<table class="table table-bordered" style="text-align: center">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀이름</th>
				<th>포지션</th>
				<th>선수이름</th>
				<th>등록일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<c:forEach var="player" items="${playerlist}">
			<tr>
				<td>${player.ROW}</td>
				<td>${player.teamname}</td>
				<td>${player.position}</td>
				<td>${player.name}</td>
				<td>${player.createDate}</td>
				<td><a href="/player/update/${player.id}">수정</a></td>
				<td><button onclick=deletePlayer(${player.id}) class="btn btn-danger"value="${player.id}">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</div>
<script src="/js/player.js"></script>

<%@ include file="../layout/footer.jsp"%>