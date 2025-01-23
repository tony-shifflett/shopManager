<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Maintenace Request</h1>
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
            <form action="/rider/maintenanceSubmit" method="post">
                <div class="mt-3 row justify-content-center">
                    <label for="pedicabNumber" class="col-sm-2 col-form-label">Your ID Number</label>
                    <div class="col-sm-10 col-lg-6">
                        <input type="number" class="form-control" id="riderId" name="riderId" value="">
                    </div>
                </div>
                <c:if test="${bindingResult.hasFieldErrors('riderID')}">
                    <div class="row justify-content-center">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10 col-lg-6">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('riderId')}">
                                <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>
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
                    <label for="details" class="col-sm-2 col-form-label">Description</label>
                    <div class="col-sm-10 col-lg-6">
                        <input type="text" class="form-control" id="details" name="details" value="">
                    </div>
                </div>
                <c:if test="${bindingResult.hasFieldErrors('details')}">
                    <div class="row justify-content-center">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-10 col-lg-6">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('details')}">
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