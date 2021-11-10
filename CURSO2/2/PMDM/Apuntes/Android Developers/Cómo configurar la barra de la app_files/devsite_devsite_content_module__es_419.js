(function(_ds){var window=this;var wL=function(a){return!a.classList.contains("material-icons")},EL=async function(a,b){await DevsiteApp.whenReady();const c=_ds.F();var d=DevsiteApp.getInsecureHost();b=b.W;if(b.origin===c.origin||!d||b.origin===d){try{var e=_ds.Be(_ds.pl,b.data)}catch(g){return}d=_ds.qe(e,1,0);if(4===d)xL(a,b);else{var f=e.getName();if(f&&(f=a.querySelector(`devsite-iframe iframe[name="${f}"]`)))switch(d){case 5:yL(e,f);break;case 8:zL(b,e,c);break;case 1:AL(b,e,c);break;case 6:case 7:BL(d,c,e);break;case 9:CL(a,
e);break;case 10:DL(e,c)}}}},IL=function(a){a.v=a.querySelector(".devsite-article-body");a.v&&FL(a);a.h&&a.h.disconnect();a.m.clear();GL(a);var b=Array.from(a.querySelectorAll(".devsite-nav-title, .devsite-page-title, td > code, th > code"));if("docs"===document.body.getAttribute("layout")&&a.v){const c=Array.from(a.v.querySelectorAll("h1, h2, h3, h4, h5, h6"));b.push(...c)}a.m.clear();a.m=new Set(b);if(_ds.F().hash){b=new _ds.iC;for(const c of a.m)_ds.hC(b,c,wL)}else HL(a,a.m);a.dispatchEvent(new CustomEvent("devsite-content-updated",
{bubbles:!0}))},GL=function(a){Array.from(a.getElementsByTagName("table")).forEach(b=>{if(!b.parentNode.classList.contains("devsite-table-wrapper")){var c=document.createElement("div");c.classList.add("devsite-table-wrapper");b.classList.contains("full-width")&&(c.classList.add("devsite-full-width-table"),b.classList.remove("full-width"));b.parentNode&&b.parentNode.insertBefore(c,b);c.appendChild(b)}})},xL=async function(a,b){var c=JL(a,b.source);c&&(a="goog_"+_ds.rh++,c.setAttribute("name",a),c=
_ds.ql(3),a=_ds.Fe(c,2,a),(b=b.source)&&b.postMessage(_ds.Ae(a),"*"))},yL=async function(a,b){const c=_ds.Dh(document).y,d=_ds.De(a,4);a=_ds.De(a,3);b=_ds.Qh(b);d&&b.setAttribute("width",`${d}px`);a&&b.setAttribute("height",`${a}px`);window.requestAnimationFrame(()=>{window.scrollTo(_ds.Dh(document).x,c)})},zL=async function(a,b,c){b=_ds.rl(_ds.ql(8),_ds.x(b,8));c=_ds.Fe(b,6,c.toString());(a=a.source)&&a.postMessage(_ds.Ae(c),"*")},AL=async function(a,b,c){b=_ds.rl(_ds.ql(2),_ds.x(b,8));c=_ds.Fe(b,
7,`${c.search}${c.hash}`);(a=a.source)&&a.postMessage(_ds.Ae(c),"*")},BL=async function(a,b,c){const d=c.Ha();b=new URL(c.getUrl(),b.origin);b=`${window.location.origin}${window.location.pathname}${b.search}${b.hash}`;6===a?window.history.pushState({},d,b):window.history.replaceState({},d,b)},CL=async function(a,b){const c=_ds.x(b,9);b=JSON.parse(_ds.x(b,10));"cloudtrackEvent"===c&&b?a.dispatchEvent(new CustomEvent("devsite-analytics-observation-cloudtrack",{detail:{eventData:b},bubbles:!0})):"devsite-apix"===
c&&a.dispatchEvent(new CustomEvent("devsite-apix-observation",{detail:b,bubbles:!0}))},DL=async function(a,b){if(a=a.getUrl()){const c=new URL(a,b.origin);a.startsWith("#")||b.origin===c.origin&&b.pathname===c.pathname&&b.search===c.search?DevsiteApp.scrollToAnchor(c.hash,!0):DevsiteApp.fetchPage(c.href)}},JL=function(a,b){let c;Array.from(a.querySelectorAll("devsite-iframe iframe")).forEach(d=>{_ds.Rh(d)===b&&(c=d)});return c},FL=function(a){"full"===document.body.getAttribute("layout")&&(a=a.v.querySelectorAll('h1[tabindex="0"],h2[tabindex="0"],h3[tabindex="0"],h4[tabindex="0"],h5[tabindex="0"],h6[tabindex="0"]'))&&
Array.from(a).forEach(b=>{b.removeAttribute("tabindex")})},HL=function(a,b){a.h&&b.forEach(c=>{a.h.observe(c)})},KL=class extends _ds.A{constructor(){super();this.C=new _ds.I;this.D=new _ds.I;this.m=new Set;this.h=null;"IntersectionObserver"in window&&(this.h=new IntersectionObserver(a=>{for(const b of a)b.isIntersecting&&(a=b.target,_ds.hC(new _ds.iC,a,wL),this.m.delete(a),this.h.unobserve(a))},{rootMargin:"100%"}))}connectedCallback(){this.C.listen(window,"message",a=>EL(this,a));IL(this)}disconnectedCallback(){this.h&&
this.h.disconnect();this.m.clear();_ds.K(this.C);_ds.K(this.D)}Ua(a){a&&([".devsite-article",".devsite-content-data","devsite-content-footer","devsite-google-survey"].forEach(b=>{_ds.Mg(this,this.querySelector(b),a.querySelector(b))}),IL(this))}};KL.prototype.updateContent=KL.prototype.Ua;KL.prototype.disconnectedCallback=KL.prototype.disconnectedCallback;KL.prototype.connectedCallback=KL.prototype.connectedCallback;try{window.customElements.define("devsite-content",KL)}catch(a){console.warn("devsite.app.customElement.DevsiteContent",a)};})(_ds_www);
