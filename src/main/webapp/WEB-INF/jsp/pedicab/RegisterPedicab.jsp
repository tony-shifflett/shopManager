<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Sign Up</h1>
        </div>
    </div>
</section>

<section class="bg-light2 pt-5 pb-5">
    <div class="container">
        <form action="/pedicab/registrationSubmit" method="post">
            <div class="mt-3 row justify-content-center">
                <label for="pedicabNumber" class="col-sm-2 col-form-label">Pedicab Number</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="number" class="form-control" id="pedicabNumber" name="pedicabNumber" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('pedicabNumber')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('pedicabNumber')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="style" class="col-sm-2 col-form-label">Style:</label>
                <div class="col-sm-10 col-lg-6">
                    <select class="form-select" id="style" name="style">
                        <option value="Boardwalk">Boardwalk</option>
                        <option value="Broadway">Broadway</option>
                        <option value="Classic">Classic</option>
                        <option value="Smash">Smash</option>
                        <option value="B2B">B2B</option>
                    </select>
                </div>
            </div>
<%--            <c:if test="${bindingResult.hasFieldErrors('password')}">--%>
<%--                <div class="row justify-content-center">--%>
<%--                    <div class="col-sm-2"></div>--%>
<%--                    <div class="col-sm-10 col-lg-6">--%>
<%--                        <c:forEach var="error" items="${bindingResult.getFieldErrors('password')}">--%>
<%--                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:if>--%>
            <div class="mt-3 row justify-content-center">
                <div class="col-sm-12 col-lg-8">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>