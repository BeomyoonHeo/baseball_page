<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">포지션별 팀의 야구 선수 페이지</h1>
<div class="container mt-3">
	<table class="table table-bordered" style="text-align: center">
		<thead>
			<tr>
				<th>포지션</th>
				<th>두산</th>
				<th>NC</th>
				<th>롯데</th>
			</tr>
		</thead>
		<c:forEach var="player" items="${playerlist}">
			<tr>
				<td>${player.position}</td>
				<td>${player.group1}</td>
				<td>${player.group2}</td>
				<td>${player.group3}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script src="/js/player.js"></script>

<%@ include file="../layout/footer.jsp"%>