<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Update Account Details</h1>
        </div>
        <div class="col-auto">
            <label class="form-check-label" for="toggleForm">Show Form</label>
            <input type="checkbox" class="form-check-input ms-2" id="toggleForm" />
        </div>
    </div>
</section>

<section class="bg-light2 pt-5 pb-5">
    <div class="container">
        <div id="formContainer" style="display: none;">
        <form action="/rider/updateSubmit" method="post">
            <div class="mt-3 row justify-content-center">
                <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="firstName" name="firstName" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('firstName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('firstName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mt-3 row justify-content-center">
                <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="lastName" name="lastName" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('password')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('lastName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <div class="mt-3 row justify-content-center">
                <label for="lastName" class="col-sm-2 col-form-label">Preferred Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="preferredName" name="preferredName" value="">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('preferred')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('preferredName')}">
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
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>
<script>
    // JavaScript to toggle form visibility
    document.getElementById('toggleForm').addEventListener('change', function () {
        const formContainer = document.getElementById('formContainer');
        formContainer.style.display = this.checked ? 'block' : 'none';
    });
</script>