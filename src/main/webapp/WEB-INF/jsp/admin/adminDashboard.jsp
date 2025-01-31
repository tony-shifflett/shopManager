<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>
<section class="bg-light py-5">
    <div class="container">
        <div class="row">
            <c:choose>
                <c:when test="${not empty openRequests}">
                    <section class="py-5">
                        <h2 class="text-center text-primary mb-4">Pending Maintenance</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped text-center">
                                <thead class="thead-dark">
                                <tr>
                                    <th>Pedicab</th>
                                    <th>Rider</th>
                                    <th>Issue</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${openRequests}" var="request">
                                    <tr>
                                        <td>${request.pedicab}</td>
                                        <td>${request.rider}</td>
                                        <td>${request.details}</td>
                                        <td>
                                            <button class="btn btn-sm btn-primary">Open Request</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </section>
                </c:when>
                <c:otherwise>
                    <section class="py-5">
                        <div class="text-center">
                            <h2 class="text-muted">No Pending Maintenance Requests</h2>
                        </div>
                    </section>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="row mt-4">
            <c:choose>
                <c:when test="${not empty pendingUsers}">
                    <section class="py-5">
                        <h2 class="text-center text-primary mb-4">Pending Users</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped text-center">
                                <thead class="thead-dark">
                                <tr>
                                    <th>Username</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pendingUsers}" var="pending">
                                    <tr>
                                        <td>${pending.email}</td>
                                        <td>
                                            <button class="btn btn-sm btn-success">Approve</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </section>
                </c:when>
                <c:otherwise>
                    <section class="py-5">
                        <div class="text-center">
                            <h2 class="text-muted">No Pending Users</h2>
                        </div>
                    </section>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
