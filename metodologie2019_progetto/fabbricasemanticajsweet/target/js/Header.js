/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta l'header
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 */
class Header {
    static createHeader() {
        console.log("Creating header");
        let navbar = document.createElement("nav");
        navbar.className = "navbar navbar-expand-lg bg-dark text-light sticky-top";
        let homeLink = document.createElement("a");
        homeLink.id = "header-home";
        homeLink.title = "Home";
        homeLink.href = "home.html";
        homeLink.className = "fas fa-home fa-2x";
        let div = document.createElement("div");
        div.className = "collapse navbar-collapse";
        $.get(Header.ISLOGGEDIN_URL, ((div, navbar, homeLink) => {
            return (result, a, ctx) => {
                if (((o1, o2) => { if (o1 && o1.equals) {
                    return o1.equals(o2);
                }
                else {
                    return o1 === o2;
                } })("true", result.toString())) {
                    let divDropdown = document.createElement("div");
                    divDropdown.className = "btn-group";
                    let buttonDropdown = document.createElement("button");
                    buttonDropdown.type = "button";
                    buttonDropdown.className = "btn btn-secondary dropdown-toggle";
                    buttonDropdown.setAttribute("data-toggle", "dropdown");
                    buttonDropdown.textContent = "Logged in";
                    let divDropdownMenu = document.createElement("div");
                    divDropdownMenu.className = "dropdown-menu dropdown-menu-right";
                    let anchorDropdownItemTask = document.createElement("a");
                    anchorDropdownItemTask.className = "dropdown-item";
                    anchorDropdownItemTask.href = "translationAnnotation.html";
                    anchorDropdownItemTask.textContent = "Task";
                    let divDropdownItemDivider = document.createElement("div");
                    divDropdownItemDivider.className = "dropdown-divider";
                    let anchorDropdownItemLogout = document.createElement("a");
                    anchorDropdownItemLogout.className = "dropdown-item";
                    anchorDropdownItemLogout.href = "logout.jsp";
                    anchorDropdownItemLogout.textContent = "Logout";
                    $(divDropdownMenu).append(anchorDropdownItemTask, divDropdownItemDivider, anchorDropdownItemLogout);
                    $(divDropdown).append(buttonDropdown, divDropdownMenu);
                    $(navbar).append(homeLink, div, divDropdown);
                }
                else {
                    let userLink = document.createElement("a");
                    userLink.id = "header-user";
                    userLink.title = "Login";
                    userLink.className = "fas fa-user-circle fa-2x";
                    userLink.id = "header-user-undefined";
                    userLink.href = Header.LOGIN_URL;
                    $(navbar).append(homeLink, div, userLink);
                }
                return null;
            };
        })(div, navbar, homeLink));
        console.log("Header done");
        return navbar;
    }
}
Header.ISLOGGEDIN_URL = "isLoggedIn.jsp";
Header.LOGIN_URL = "login.html";
Header["__class"] = "Header";
