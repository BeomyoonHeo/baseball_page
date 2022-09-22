<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">팀 목록 페이지 입니다.</h1>
<div class="container mt-3">
	<table class="table table-bordered" style="text-align: center">
		<thead>
			<tr>
				<th>번호</th>
				<th>경기장이름</th>
				<th>팀이름</th>
				<th>창단일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<c:forEach var="team" items="${teamlist}">
			<tr>
				<td>${team.ROW}</td>
				<td>${team.stadiumname}</td>
				<td>${team.name}</td>
				<td>${team.createDate}</td>
				<td><a href="/stadium/update/${team.id}">수정</a></td>
				<td><button id="btnStadiumDelete" class="btn btn-danger" value="${team.id}">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</div>
<script src="/js/stadium.js"></script>

<%@ include file="../layout/footer.jsp"%>