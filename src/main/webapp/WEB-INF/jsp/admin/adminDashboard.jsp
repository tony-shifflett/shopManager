<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>
<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <c:choose>
                <c:when test="${not empty openRequests}">
                    <section class="bg-light1 pt-5 pb-5">
                        <h2 class="text-center">Pending Maintenance</h2>
                        <table class = "table mt-5">
                            <tr>
                                <th>Pedicab: </th>
                                <th>Rider: </th>
                                <th>Issue: </th>
                            </tr>
                            <c:forEach items="${openRequests}" var="request">
                                <tr>
                                    <td>${request.pedicab}</td>
                                    <td>${request.rider}</td>
                                    <td>${request.details}</td>
                                    <td><button>Open Request</button></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </section>
                </c:when>
                <c:otherwise>
                    <section class="bg-light1 pt-5 pb-5">
                        <div class="text-center">
                            <h2>No Pending Maintenance Requests</h2>
                        </div>
                    </section>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="row">
            <c:choose>
                <c:when test="${not empty pendingUsers}">
                    <section class="bg-light1 pt-5 pb-5">
                        <h2 class="text-center">Pending Users</h2>
                        <table class = "table mt-5">
                            <tr>
                                <th>Username: </th>
                            </tr>
                            <c:forEach items="${pendingUsers}" var="pending">
                                <tr>
                                    <td>${pending.email}</td>
                                    <td><button>Approve</button></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </section>
                </c:when>
                <c:otherwise>
                    <section class="bg-light1 pt-5 pb-5">
                        <div class="text-center">
                            <h2>No Pending Users</h2>
                        </div>
                    </section>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>