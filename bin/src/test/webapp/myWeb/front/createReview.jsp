<form id="welcome" action="Employee" method="get">
=======
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="welcome" action="welcome" method="get">
 <center>
    <label>Welcome! ${lastName} ${firstName} AS Customer</label> 
     </center>
</form>
<label><b>ProductNumber:</b> ${productNumber}</label>
<br/>
<label><b>Your review:</b> ${description}</label>
<br/>

<br/> 
<form id="logout" action="logout" method="post"> 
 <center>
    <button>logout</button>
     <center>
</form>



<form id="createReview" action="createReview" method="post"> 
    <button>Create Review</button>
