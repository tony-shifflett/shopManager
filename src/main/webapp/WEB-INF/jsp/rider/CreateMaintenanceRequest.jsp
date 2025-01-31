<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light pt-5 pb-5">
    <div class="container">
        <div class="row mb-4">
            <h1 class="m-0 text-center">Maintenance Request</h1>
        </div>
        <div class="row justify-content-center mb-4">
            <div class="col-auto">
                <label class="form-check-label" for="toggleForm">Show Form</label>
                <input type="checkbox" class="form-check-input ms-2" id="toggleForm" />
            </div>
        </div>
    </div>
</section>
<section class="bg-light pt-4 pb-5">
    <div class="container">
        <div id="formContainer" class="card shadow p-4" style="display: none;">
            <form action="/rider/maintenanceSubmit" method="post">
                <div class="mb-3 row">
                    <label for="riderId" class="col-sm-3 col-form-label">Your ID Number</label>
                    <div class="col-sm-9">
                        <input type="number" class="form-control" id="riderId" name="riderId" value="">
                        <c:if test="${bindingResult.hasFieldErrors('riderID')}">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('riderId')}">
                                <div class="text-danger small mt-1">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="pedicabNumber" class="col-sm-3 col-form-label">Pedicab Number</label>
                    <div class="col-sm-9">
                        <input type="number" class="form-control" id="pedicabNumber" name="pedicabNumber" value="">
                        <c:if test="${bindingResult.hasFieldErrors('pedicabNumber')}">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('pedicabNumber')}">
                                <div class="text-danger small mt-1">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="details" class="col-sm-3 col-form-label">Description</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" id="details" name="details" rows="3"></textarea>
                        <c:if test="${bindingResult.hasFieldErrors('details')}">
                            <c:forEach var="error" items="${bindingResult.getFieldErrors('details')}">
                                <div class="text-danger small mt-1">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary px-5">Submit</button>
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
