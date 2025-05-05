<!-- Page heading-->
<h1 class="mb-5">
    <img src="/assets/favicon.ico" alt="URL Icon"
         style="height: 1em; margin-right: 0.3em; vertical-align: middle;">
    Short Link's Stats
</h1>
<!-- Statistics Card-->
<div class="card m-3" style="width: 100%;">
    <div class="card-title text-dark h3 p-3">${statistics.code}</div>
    <div class="card-body">
        <p class="text-dark">
            <span class="h5 d-inline text-dark text-start">Long Url:</span> <a href=${statistics.url}>${statistics.url}</a>
        </p>
        <p class="text-dark">
            <span class="h5 d-inline text-dark text-start">Created At: </span> ${statistics.createdAt}
        </p>
        <p class="text-dark">
            <span class="h5 d-inline text-dark text-start">Updated At: </span> ${statistics.updatedAt}
        </p>
        <p class="text-dark">
            <span class="h5 d-inline text-dark text-start">Use Count: </span> ${statistics.useCount}
        </p>
    </div>
</div>