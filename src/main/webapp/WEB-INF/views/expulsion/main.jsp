<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">퇴출선수 목록 페이지 입니다.</h1>
<div class="container mt-3">
	<table class="table table-bordered" style="text-align: center">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀이름</th>
				<th>포지션</th>
				<th>선수이름</th>
				<th>사유</th>
				<th>퇴출일</th>
			</tr>
		</thead>
		<c:forEach var="player" items="${playerlist}">
			<tr>
				<td>${player.ROW}</td>
				<td>${player.teamname}</td>
				<td>${player.position}</td>
				<td>${player.playername}</td>
				<td>${player.reason}</td>
				<td>${player.createDate}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script src="/js/expulsion.js"></script>

<%@ include file="../layout/footer.jsp"%>