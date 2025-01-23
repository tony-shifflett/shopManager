<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp"/>
<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <c:choose>
                <c:when test="${not empty riders}">
                    <section class="bg-light1 pt-5 pb-5">
                        <h2 class="text-center">Riders</h2>
                        <table class = "table mt-5">
                            <tr>
                                <th>First Name: </th>
                                <th>Last Name: </th>
                            </tr>
                            <c:forEach items="${riders}" var="rider">
                                <tr>
                                    <td>${rider.firstName}</td>
                                    <td>${rider.lastName}</td>
                                    <td><button>Edit</button></td>

                                </tr>
                            </c:forEach>
                        </table>
                    </section>
                </c:when>
                <c:otherwise>
                    <section class="bg-light1 pt-5 pb-5">
                        <div class="text-center">
                            <h2>No Riders Found</h2>
                        </div>
                    </section>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>
<jsp:include page = "../include/footer.jsp"/>