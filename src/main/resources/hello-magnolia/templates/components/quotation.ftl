<div class="card">
  <div class="card-image">
    <img src=${model.getBackgroundImage()} class="img-responsive">
  </div>
  <div class="card-header">
    <div class="card-title h5">${model.getTitle()}</div>
    <div class="card-subtitle text-gray"><span class="chip">${model.getCategory()}</span></div>
  </div>
  <div class="card-body">
    ${model.getQuoteText()}- ${model.getAuthor()}
  </div>
  <div class="card-footer" class="bg-primary">
    <p>Date: ${model.getDate()}</p>
    <p>Tags: ${model.getTags()}</p>
  </div>
</div>