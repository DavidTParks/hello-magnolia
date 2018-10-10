<!DOCTYPE html>
<html xml:lang="${cmsfn.language()}" lang="${cmsfn.language()}">
  <head>
    [@cms.page /]
    <title>${content.windowTitle!content.title!}</title>
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-exp.min.css">
    <link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">

  </head>
  <body>
    <div class="container" class="bg-secondary">
    <h1 class="kbd">Quote Generator</h1>
      <div class="main">
         [@cms.area name="main"/]
      </div>
    </div>
 
  </body>
</html>