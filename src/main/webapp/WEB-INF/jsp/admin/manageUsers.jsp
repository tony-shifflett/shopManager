<jsp:include page="../include/header.jsp"/>
<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <form action="/admin/manage-users/search" class="mb-0">
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="mb-3">
                        <label for="nameId" class="form-label">Rider:</label>
                        <input type="text" class="form-control" id="nameId" name="preferredName" value="${search}">
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>

