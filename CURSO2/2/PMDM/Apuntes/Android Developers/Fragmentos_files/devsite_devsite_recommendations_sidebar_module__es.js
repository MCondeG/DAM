(function(_ds){var window=this;var $U=function(a){var b=a.pd,c=a.Uf;a='<div class="devsite-recommendations-sidebar-heading" role="heading" aria-level="2"><a href="#recommendations-link" class="devsite-nav-title devsite-recommendations-sidebar-heading-link" data-category="Site-Wide Custom Events" data-label="devsite-recommendation side-nav title" data-action="click" data-tooltip="'+_ds.iq("See content recommendations");a+='"><svg class="devsite-recommendations-sidebar-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true"><path d=\'M12.5,8.5L10,3L7.5,8.5L2,11l5.5,2.5L10,19l2.5-5.5L18,11L12.5,8.5z M18,13l-1.25,2.75L14,17l2.75,1.25L18,21l1.25-2.75 L22,17l-2.75-1.25L18,13z\'/></svg><span class="devsite-nav-text devsite-nav-title">'+
_ds.R(c)+'</span></a></div><ul class="devsite-nav-list">';c=b.length;for(let d=0;d<c;d++)a+=ZU(b[d]);return(0,_ds.Q)(a+"</ul>")},ZU=function(a){const b=[a.Ga(),_ds.y(a,3),_ds.y(a,4)];a='<li role="option" class="devsite-nav-item"><a href="'+_ds.S(_ds.V(a.getUrl()+"?"+_ds.y(a,8)))+'" class="devsite-nav-title devsite-recommendations-sidebar-title" data-category="Site-Wide Custom Events" data-label="devsite-recommendation side-nav link" data-action="click"><span class="devsite-nav-text" tooltip="">'+
_ds.R(b.filter(c=>0<(""+_ds.Yp(c)).length)[0])+'</span></a><div class="significatio-card-meta">Updated <span class="significatio-date" date="'+_ds.S(_ds.ve(_ds.Db(a,_ds.$y,7),1))+'"></span></div></li>';return(0,_ds.Q)(a)};var aV=function(a){a.eventHandler.listen(a,"click",b=>{b.target.classList.contains("devsite-nav-title")&&(b=b.target,a.m&&a.m.classList.remove("devsite-nav-active"),b.classList.add("devsite-nav-active"),a.m=b)});a.eventHandler.listen(document,"devsite-on-recommendations",b=>{b=b.W;if(null===b||void 0===b?0:b.detail)if(b=b.detail,3===b.C()){a.render(b);a.h.j();if(b=null===b||void 0===b?void 0:b.m()){for(const c of b)if(b=_ds.Db(c,_ds.zG,10))b={targetPage:c.getUrl(),targetRank:_ds.ve(b,2),targetType:_ds.ie(b,
3,0),targetIdenticalDescriptions:_ds.ve(b,4),targetTitleWords:_ds.ve(b,5),targetDescriptionWords:_ds.ve(b,6),experiment:_ds.y(b,7)},b={category:"Site-Wide Custom Events",action:"recommended-right-nav",label:c.getUrl(),additionalParams:{recommendations:b}},a.dispatchEvent(new CustomEvent("devsite-analytics-observation",{detail:b,bubbles:!0}));a.v.j()}else a.v.h("empty");a.classList.add("recommendations-rendered")}else a.h.j()});a.eventHandler.listen(document.body,"devsite-recommendations-disconnected",
()=>{_ds.Fh(a);a.classList.remove("recommendations-rendered")})},bV=class extends _ds.C{constructor(a){super();this.timeZone=a;this.eventHandler=new _ds.H(this);this.h=new _ds.rk;this.loaded=this.h.promise;this.v=new _ds.rk;this.m=null}connectedCallback(){aV(this)}disconnectedCallback(){_ds.K(this.eventHandler);this.h.h("Disconnected")}render(a){if(this.isConnected){_ds.L(this,$U,{pd:a.m(),Uf:a.F()});a=Array.from(this.querySelectorAll(".significatio-date"));for(const b of a){a=b.getAttribute("date");
try{b.textContent=(new Date(1E3*Number(a))).toLocaleDateString("default",{month:"short",year:"numeric",day:"numeric",timeZone:this.timeZone})}catch(c){}}}}};try{window.customElements.define("devsite-recommendations-sidebar",bV)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteRecommendationsSidebar",a)};})(_ds_www);