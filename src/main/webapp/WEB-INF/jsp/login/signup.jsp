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
        <form action="/login/signupSubmit" method="post">
            <div class="mt-3 row justify-content-center">
                <label for="username" class="col-sm-2 col-form-label">Username</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="username" name="username" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('username')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('username')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="password" class="form-control" id="password" name="password" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('password')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('password')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>


            <div class="mt-3 row justify-content-center">
                <label for="fullname" class="col-sm-2 col-form-label">Full Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="fullname" name="fullname" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('fullname')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('fullname')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <div class="col-sm-12 col-lg-8">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>