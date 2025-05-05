<!-- Page heading-->
<h1 class="mb-5">
    <img src="/assets/favicon.ico" alt="URL Icon"
         style="height: 1em; margin-right: 0.3em; vertical-align: middle;">
    Shorten a long Url
</h1>
<form action="/shorten" method="POST" class="form-subscribe" id="contactForm">
    <!-- Email address input-->
    <div class="row">
        <div class="col">
            <input class="form-control form-control-lg" id="url" name="url"
                   placeholder="Enter a Long Link Here" />
        </div>
        <div class="col-auto"><button class="btn btn-primary btn-lg" id="submitButton"
                                      type="submit">Shorten</button></div>
    </div>
</form>