<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<h1 style="text-align: center">경기장 목록 페이지 입니다.</h1>
<div class="container mt-3">
	<table class="table table-bordered" style="text-align: center">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>개장일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<c:forEach var="stadium" items="${stadiumlist}">
			<tr>
				<td>${stadium.ROW}</td>
				<td>${stadium.name}</td>
				<td>${stadium.createDate}</td>
				<td><a href="/stadium/update/${stadium.id}">수정</a></td>
				<td><button id="btnStadiumDelete" class="btn btn-danger" value="${stadium.id}">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
</div>
<script src="/js/stadium.js"></script>

<%@ include file="../layout/footer.jsp"%>