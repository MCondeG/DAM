(function(_ds){var window=this;var kV=function(a){Array.from(a.children).forEach(b=>{if(b.matches(".ds-selector-tabs,.ds-selector-dropdown,.code-sample,.data-sample")){const c=b.getAttribute("data-ds-scope");c&&a.setAttribute("scope",c);const d=".ds-selector-tabs,.ds-selector-dropdown,.code-sample,.data-sample".split(/[,.]/).filter(e=>e.length);Array.from(b.classList).forEach(e=>{d.includes(e)||a.classList.add(e)});for(b.hasAttribute("no-overflow")&&a.setAttribute("no-overflow","");b.childNodes.length;)a.appendChild(b.childNodes[0]);
_ds.B(b)}});Array.from(a.children).forEach(b=>{b.matches(".kd-tabbed-horz,.kd-tabbed-vert")&&jV(a,b)})},lV=function(a){a.v=!0;var b=a.getAttribute("scope");let c=null;var d=_ds.F().searchParams.get("tab");d&&(c=_ds.jj(d));c||a.hasAttribute("no-pref")||(c=a.C.get(`pref_ds_${b}`));const e=a.ownerDocument.createElement("devsite-tabs");e.setAttribute("role","tablist");a.hasAttribute("no-overflow")&&e.setAttribute("no-overflow","");a.h=e;Array.from(a.children).filter(g=>g.matches("section")).forEach(g=>
{const h=a.ownerDocument.createElement("tab"),k=a.ownerDocument.createElement("a");g.querySelector(".two-line-tab")&&h.setAttribute("two-line","");h.setAttribute("role","tab");h.setAttribute("aria-selected","false");const l=g.querySelector("h1,h2,h3,h4,h5,h6");var m="";let n;if(l&&""!==l.textContent.trim()){m="";l.id&&(n=l.id);var q=l.querySelector(".firebase-platform-label");q&&(m=q.textContent.trim(),_ds.B(q));q=l.textContent;var v=g.querySelector("[tab-label]");v&&(m=v.getAttribute("tab-label"));
_ds.B(l);m?(v=a.ownerDocument.createElement("span"),v.setAttribute("tab-label",m),v.textContent=q.trim(),k.appendChild(v),m=_ds.jj(`${q} ${m}`)):(k.append(...l.childNodes),m=_ds.jj(q)||"tab");h.setAttribute("aria-controls",`tabpanel-${m}`);k.id=`aria-tab-${m}`;k.setAttribute("role","button");l.hasAttributes()&&Array.from(l.attributes).forEach(w=>{w.name.startsWith("track-")&&k.setAttribute(w.name,w.value)})}else m="Error",l&&(m=l.getAttribute("data-text")||"Error"),k.textContent=m,m=_ds.jj(m);_ds.$g(k,
`#${m}`);h.appendChild(k);e.querySelector(`[${"tab"}="${m}"]`)||(h.setAttribute("tab",m),n&&(h.id=n),e.appendChild(h));g.setAttribute("tab",m);g.setAttribute("role","tabpanel");g.setAttribute("aria-labelledby",`aria-tab-${m}`);g.setAttribute("tabindex","0");g.id=`tabpanel-${m}`});_ds.Kh(a,e,0);b=_ds.F().hash.substring(1);var f=Array.from(a.children);d=e.querySelector(`tab[id="${b}"]`);(f=f.find(g=>g.matches(".selected")))&&f.classList.remove("selected");b&&d?a.setAttribute("active",d.getAttribute("tab")):
c&&e.querySelector(`[${"tab"}="${c}"]`)?a.setAttribute("tab-to-select",c):f?a.setAttribute("active",f.getAttribute("tab")):a.hasAttribute("active")||a.setAttribute("active",e.querySelector("[tab]").getAttribute("tab"));a.setAttribute("ready","")},nV=function(a){a.h&&a.m.listen(a.h,"click",b=>{if(!b.defaultPrevented){b.preventDefault();b.stopPropagation();document.body.dispatchEvent(new CustomEvent("devsite-close-overflow-tabs"));b=b.target;for(var c;!c&&b!==a;)"TAB"===b.tagName.toUpperCase()&&(c=
b),b=b.parentNode;c&&mV(a,c.getAttribute("tab"))}})},mV=function(a,b){const c=a.getBoundingClientRect();a.dispatchEvent(new CustomEvent("devsite-sticky-freeze",{bubbles:!0}));const d=a.getAttribute("scope");Array.from(a.ownerDocument.querySelectorAll(`${"devsite-selector"}[${"scope"}="${d}"]`+`:not([${"active"}="${b}"])`)).forEach(g=>{g!==a&&g.setAttribute("tab-to-select",b)});a.setAttribute("active",b);const e=a.getBoundingClientRect();window.scrollTo(_ds.Dh(document).x,_ds.Dh(document).y+e.top-
c.top);a.hasAttribute("no-pref")||a.C.set(`pref_ds_${d}`,b);let f;Array.from(a.children).forEach(g=>{!f&&g.matches("devsite-tabs")&&(f=g.querySelector(`[${"tab"}="${b}"]`))});f&&f.id&&_ds.Ui(`#${f.id}`,!0);a.dispatchEvent(new CustomEvent("devsite-content-updated",{bubbles:!0}))},jV=function(a,b){Array.from(b.children).forEach(c=>{if(c.matches("article")){const d=a.ownerDocument.createElement("section");for(c.classList.contains("selected")&&d.classList.add("selected");c.childNodes.length;)d.appendChild(c.childNodes[0]);
const e=d.querySelector("header");if(e){const f=a.ownerDocument.createElement("h3");e.childNodes.length&&f.append(...e.childNodes);f.id=e.id;_ds.Lh(f,e)}a.appendChild(d);_ds.B(c)}});_ds.B(b)},oV=class extends _ds.A{static get observedAttributes(){return["active","tab-to-select"]}constructor(){super(["devsite-tabs"]);this.m=new _ds.I;this.v=!1;this.C=new _ds.cm;this.h=null}connectedCallback(){kV(this);this.getAttribute("scope")||this.setAttribute("scope","auto");this.v||lV(this);nV(this)}disconnectedCallback(){_ds.K(this.m)}attributeChangedCallback(a,
b,c){const d=[],e=Array.from(this.children);e.forEach(f=>{f.matches(`section[${"tab"}="${c}"]`)?d.push(f):f.matches("devsite-tabs")&&(f=f.querySelector(`tab[${"tab"}="${c}"]`))&&d.push(f)});"active"===a&&c&&(d.length?(e.forEach(f=>{if(f.matches("section[tab][active]"))f.removeAttribute("active");else if(f.matches("devsite-tabs")){const g=f.querySelector("tab[tab][active]");g&&(g.removeAttribute("active"),g.setAttribute("aria-selected","false"),(f=f.querySelector("a[aria-selected=true]"))&&f.removeAttribute("aria-selected"))}}),
d.forEach(f=>{f.setAttribute("active","");if(f.matches("tab")){f.setAttribute("aria-selected","true");const g=f.querySelector("a");g&&g.setAttribute("aria-selected","true")}Array.from(f.querySelectorAll("iframe[data-src]")).forEach(g=>{g.setAttribute("src",g.getAttribute("data-src"));g.removeAttribute("data-src")})})):this.setAttribute(a,b));if("tab-to-select"===a&&c){if(d.length)this.setAttribute("active",c);else{const f=this.getAttribute("active");e.forEach(g=>{g.matches("devsite-tabs")&&(g=g.querySelector(`tab[${"tab"}="${f}"]`))&&
this.setAttribute("active",g.getAttribute("tab"))})}this.removeAttribute("tab-to-select")}}};oV.prototype.attributeChangedCallback=oV.prototype.attributeChangedCallback;oV.prototype.disconnectedCallback=oV.prototype.disconnectedCallback;oV.prototype.connectedCallback=oV.prototype.connectedCallback;try{window.customElements.define("devsite-selector",oV)}catch(a){console.warn("devsite.app.customElement.DevsiteSelector",a)};})(_ds_www);
