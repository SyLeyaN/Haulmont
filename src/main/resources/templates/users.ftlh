<#import "parts/common.ftlh" as c>

<@c.page>
    <h4><font color="#dc143c">${messageError!""}</font></h4>
    <br><h5>Add new user</h5>
<div class="form-row align-items-center mt-3">
<form action="addUserDAO" method="post">
    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect" > First name: </label>
        <div class="col-sm-5">
            <input type="text" name="firstName" class="form-control" placeholder="Ivan"/>
        </div>
    </div>

    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect" > Middle name: </label>
        <div class="col-sm-5">
            <input type="text" name="midName" class="form-control" placeholder="Ivanovich" />
        </div>
    </div>

    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect" > Last name: </label>
        <div class="col-sm-5">
            <input type="text" name="lastName" class="form-control" placeholder="Ivanov"/>
        </div>
    </div>

    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Telephone: </label>
        <div class="col-sm-5">
            <input type="text" name="telephone" class="form-control" placeholder="8-###-###-##-##"/>

        </div>
    </div>

    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"  > Email: </label>
        <div class="col-sm-5">
            <input type="text" name="email" class="form-control" placeholder="ivanov@gmail.com" />
        </div>
    </div>

    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Passport: </label>
        <div class="col-sm-5">
            <input type="text" name="passport" class="form-control"placeholder="##-##-###-###"/>
        </div>
    </div>

    <button type="submit" class="btn btn-primary ml-2 mt-2 mb-2">Create</button>
</form>

    </div>

    <div><h4>List of users</h4></div>
    <#if userSize!=0>
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="align-middle text-center" >Name</th>
                <th class="align-middle text-center" >Passport</th>
                <th class="align-middle text-center" >Telephone</th>
                <th class="align-middle text-center" >Email</th>
                <th class="align-middle text-center" >Full info</th>
            </tr>
            </thead>
            <tbody>
            <#list usrs as usr>
                <tr>
                    <td class="align-middle text-center" >${usr.firstName} ${usr.midName} ${usr.lastName}</td>
                    <td class="align-middle text-center" >${usr.passport}</td>
                    <td class="align-middle text-center" >${usr.telephone}</td>
                    <td class="align-middle text-center">${usr.email}</td>
                    <td class="align-middle text-center" ><a href="users/${usr.id}">Banks and offers</a></td>
                    <td class="align-middle text-center" >
                                <form action="/delete" method="post">
                                    <input type="hidden" name="passport" value="${usr.passport}"/>
<#--                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
                                    <button type="submit" class="btn btn-outline-danger ml-2 mt-2" name="delete">Delete</button>
                                </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div class="alert alert-primary col-sm-5" role="alert">
            There are no users!
        </div>

    </#if>

</@c.page>