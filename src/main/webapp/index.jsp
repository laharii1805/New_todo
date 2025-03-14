<%@ page import="java.util.List, model.Todo" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

<title>To-Do Task List</title>

<link rel="stylesheet" href="bootstrap.min.css">

<script>

function validateForm() {

var rollno=document.getElementById("rollno").value.toUpperCase();

if(rollno.length!=10){

alert("Length of rollno should be 10 characters");

return false;

}

var desc = document.getElementById("description").value;

if (desc.length < 3) {

alert("Description must be at least 3 characters long.");

return false; // Prevent form submission

}

return true; // Allow form submission

}



function confirmDelete(id) {

if (confirm("Are you sure you want to delete this task?")) {

window.location.href = "delete?id=" + id;

}

}



function showUpdateForm(id,rollno, title, description, last_date, status) {

document.getElementById("updateForm").style.display = "block";

document.getElementById("updateId").value = id;

document.getElementById("updaterollno").value = rollno; 

document.getElementById("updateTitle").value = title;

document.getElementById("updateDescription").value = description;

document.getElementById("updateLastDate").value = last_date;

document.getElementById("updateStatus").value = status;

}



function hideUpdateForm() {

document.getElementById("updateForm").style.display = "none";

}

</script>

</head>

<body>

<div class="container">

<h2 class="mt-4">To-Do Task List</h2>

<!-- Add Task Form -->

<form action="add" method="post" onsubmit="return validateForm()">

<input type="text" name="rollno" placeholder= "Roll No" required>

<input type="text" name="title" placeholder="Title" required> 

<input type="text" id="description" name="description" placeholder="Description">

<input type="date" id="last_date" name="last_date" placeholder="Last Date" required>

<button type="submit" class="btn btn-primary">Add</button>

</form><br>

<form name='lstfrm' action="list" method="get">

<button type="submit" class="btn btn-success">show</button>

</form>



<div id="updateForm" style="display: none;background-color:skyblue" class="mt-3">

<h3>Update Task</h3>

<form action="update" method="post">

<input type="hidden" id="updateId" name="id">

<input type="text" id="updateRollno" name="rollno" placeholder="Roll No" required>

<input type="text" id="updateTitle" name="title" placeholder="Title" required>

<input type="text" id="updateDescription" name="description" placeholder="Description" required>

<input type="date" id="updateLastDate" name="last_date" placeholder="Last Date" required>

<select id="updateStatus" name="status" required>

<option value="Pending">Pending</option>

<option value="Completed">Completed</option>

</select>

<button type="submit" class="btn btn-success">Update</button>

<button type="button" class="btn btn-secondary" onclick="hideUpdateForm()">Cancel</button>

</form><br>

</div>

<!-- Task List Table -->

<table class="table mt-3">

<tr>

<th>Roll No</th>

<th>Title</th>

<th>Description</th>

<th>Last Date</th>

<th>Status</th>

<th colspan="2">Action</th>

</tr>

<%

List<Todo> todos = (List<Todo>) request.getAttribute("todos");

if (todos != null) {

for (Todo todo : todos) {

%>

<tr>

<td><%= todo.getRollno() %></td>

<td><%= todo.getTitle() %></td>

<td><%= todo.getDescription() %></td>

<td><%= todo.getLast_date() %></td>

<td><%= todo.getStatus() %></td>

<td>

<a href="javascript:void(0);" onclick="confirmDelete(<%= todo.getId() %>)" class="btn btn-danger">Delete</a>

</td>

<td>

<a href="javascript:void(0);" onclick="showUpdateForm(<%= todo.getId() %>, '<%= todo.getRollno() %>', '<%= todo.getTitle() %>', '<%= todo.getDescription() %>', '<%= todo.getLast_date() %>', '<%= todo.getStatus() %>')" class="btn btn-warning">Update</a>

</td>

</tr>

<% }

} %>

</table>

</div>

</body>

</html>