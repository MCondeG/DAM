(function(_ds){var window=this;var BV=class extends _ds.A{constructor(){super();this.eventHandler=new _ds.I}static get observedAttributes(){return["visible"]}connectedCallback(){this.eventHandler.listen(document.body,"devsite-sitemask-show",()=>this.show());this.eventHandler.listen(document.body,"keydown",a=>{"Escape"===a.key&&this.hasAttribute("visible")&&(a.preventDefault(),a.stopPropagation(),this.jb())});this.eventHandler.listen(document.body,"devsite-sitemask-hide",()=>this.jb());this.eventHandler.listen(this,"click",()=>
this.jb())}attributeChangedCallback(a,b,c){"visible"===a&&(null==c?this.dispatchEvent(new CustomEvent("devsite-sitemask-hidden",{bubbles:!0})):this.dispatchEvent(new CustomEvent("devsite-sitemask-visible",{bubbles:!0})))}disconnectedCallback(){_ds.K(this.eventHandler)}show(){this.setAttribute("visible",this.getAttribute("visible")||"")}jb(){this.removeAttribute("visible")}};BV.prototype.hide=BV.prototype.jb;BV.prototype.show=BV.prototype.show;BV.prototype.disconnectedCallback=BV.prototype.disconnectedCallback;
BV.prototype.attributeChangedCallback=BV.prototype.attributeChangedCallback;BV.prototype.connectedCallback=BV.prototype.connectedCallback;try{window.customElements.define("devsite-sitemask",BV)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteSitemask",a)};})(_ds_www);
