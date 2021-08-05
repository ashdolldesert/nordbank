# Create a new Project

Getting Started

```
ng new ng12simple
```

Run it

```
cd ng12simple
ng serve
```

Lets try

[localhost:4200/](http://localhost:4200/)

# Ng12simple

## Install cleave.js

```
npm i -S cleave.js ngx-cleave-directive
```



```
npm WARN ajv-keywords@3.5.2 requires a peer of ajv@^6.9.1 but none is installed. You must install peer dependencies yourself.
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@2.3.2 (node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@2.3.2: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})     
npm WARN optional SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.13 (node_modules\webpack-dev-server\node_modules\fsevents):
npm WARN notsup SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.13: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})    

+ cleave.js@1.6.0
+ ngx-cleave-directive@1.1.3
added 3 packages from 3 contributors, removed 1 package and audited 1327 packages in 6.498s

87 packages are looking for funding
  run `npm fund` for details

found 1 moderate severity vulnerability
  run `npm audit fix` to fix them, or `npm audit` for details
```

## Setting up demo of cleave.js

see the following

- app.component.html
- app.component.scss
- app.component.ts
- app.module.ts

## Demo cleave.js

[localhost:4200/](http://localhost:4200/)

## Create new page for cleave.js

```bash
ng g component cleavejs
```

Copy and paste app.component.** to cleavejs.component.**

- cleavejs.component.html
- cleavejs.component.scss
- cleavejs.component.ts

## Setting up routing for cleave.js

```typescript
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CleavejsComponent } from 'src/app/cleavejs/cleavejs.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: CleavejsComponent },
  { path: 'cleavejs', component: CleavejsComponent },
  // { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

```



