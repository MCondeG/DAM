(function(_ds){var window=this;var fR=function(a){return(0,_ds.Q)('<span class="devsite-heading" role="heading" aria-level="'+_ds.T(a.level)+'"></span>')},gR=function(a){var b=a.id;a=a.label;return(0,_ds.Q)('<button type="button" class="devsite-heading-link button-flat material-icons" aria-label="'+_ds.T(a)+'" data-title="'+_ds.T(a)+'" data-id="'+_ds.T(b)+'"></button>')};var hR=async function(a){a.m=Array.from(document.querySelectorAll("h1.add-link[id],h2:not(.no-link)[id],h3:not(.no-link)[id],h4:not(.no-link)[id],h5:not(.no-link)[id],h6:not(.no-link)[id]"));const b=await _ds.u();for(const c of a.m)b.registerIntersectionForElement(c,()=>{var d=c;if(!d.querySelector(".devsite-heading-link")&&(d.classList.contains("add-link")||!("full"===document.body.getAttribute("layout")||_ds.ai(d,"devsite-dialog",null,3)||_ds.ai(d,"devsite-selector",null,6)||_ds.ai(d,"table",null,
4)))){var e=d.textContent||d.dataset.text;if(e&&d.id){const f="Copiar el v\u00ednculo a esta secci\u00f3n: "+e,g=_ds.M(fR,{level:d.tagName[1]});for(const h of Array.from(d.childNodes))g.append(h);d.append(g);e=_ds.M(gR,{id:d.id,label:e?f:"Copia el v\u00ednculo a esta secci\u00f3n"});d.appendChild(e);d.setAttribute("role","presentation");d.removeAttribute("tabindex")}}b.unregisterIntersectionForElement(c)})},jR=function(a){a.eventHandler.listen(document.body,"devsite-page-changed",()=>{hR(a)});a.eventHandler.listen(document,
"click",b=>{b=b.target;if(b.classList.contains("devsite-heading-link")){var c=_ds.ai(b,"devsite-expandable",null,3),d=c?c.id:b.dataset.id;d&&(c=_ds.F(),c.hash=d,d=document.createElement("div"),d.innerText=c.href,_ds.Xo(a,[d]),iR(a,b))}})},iR=async function(a,b){if(a.h){const c=b.getAttribute("aria-label");b.setAttribute("aria-label","Se copi\u00f3 el v\u00ednculo a esta secci\u00f3n en el portapapeles");_ds.uk(a.eventHandler,a.h,_ds.Oe,()=>{_ds.uk(a.eventHandler,a.h,_ds.Oe,()=>{b.setAttribute("aria-label",
c)})})}},kR=class extends _ds.A{constructor(){super();this.eventHandler=new _ds.I;this.h=null;this.m=[]}async connectedCallback(){await hR(this);jR(this);this.h=document.querySelector("devsite-snackbar")}async disconnectedCallback(){const a=await _ds.u();for(const b of this.m)a.unregisterIntersectionForElement(b);_ds.K(this.eventHandler)}};try{window.customElements.define("devsite-heading-link",kR)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteHeadingLink",a)};})(_ds_www);
