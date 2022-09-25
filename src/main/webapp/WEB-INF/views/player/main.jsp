<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">선수 목록 페이지 입니다.</h1>
<div class="container mt-3">
<div style="text-align: right">
<select id="teamgroup">
<c:forEach var="team" items="${teamlist}">
<option value="${team.id}">${team.name}</option>
</c:forEach>
</select>
<button id="btnDelete" class="btn btn-danger">삭제하기</button></div>
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
		<tbody id="table">
		<c:forEach var="player" items="${playerlist}">
			<tr>
				<td>${player.ROW}</td>
				<td>${player.teamname}</td>
				<td>${player.position}</td>
				<td>${player.name}</td>
				<td>${player.createDate}</td>
				<td><a href="/player/update/${player.id}">수정</a></td>
				<td><input class="form-check-input" type="checkbox" name="checkbox" value="${player.id}"></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<script src="/js/player.js"></script>

<%@ include file="../layout/footer.jsp"%>