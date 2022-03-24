<#import "parts/common.ftlh" as c>

<@c.page>
    <h4><font color="#dc143c">${messageError!""}</font></h4>
<div class="container-fluid">
    <div class="form-group col-md-6">
        <form action="/users/${usr.id}/updateUser" method="post">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">First name: </label>
            <div class="col-sm-5">
                <input type="text" name="fname" value="${usr.firstName}"></label>
            </div>
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Second name: </label>
            <div class="col-sm-5">
                <input type="text" name="mname" value="${usr.midName}"></label>
            </div>
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Last name: </label>
            <div class="col-sm-5">
                <input type="text" name="lname" value="${usr.lastName}"></label>
            </div>
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Telephone: </label>
            <div class="col-sm-5">
                <input type="text" name="telephone" value="${usr.telephone}"></label>
            </div>
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Email: </label>
            <div class="col-sm-5">
                <input type="text" name="email" value="${usr.email}"></label>
            </div>
            <button type="submit" class="btn btn-primary ml-2 mt-2">Save</button>
        </form>
    </div>

    <#if offerSize!=0>
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="align-middle text-center" >Credit name</th>
                <th class="align-middle text-center" >All payment</th>
                <th class="align-middle text-center" >Bank name</th>
                <th class="align-middle text-center" >Month payment</th>
                <th class="align-middle text-center" >Limit (month)</th>
                <th class="align-middle text-center" >Rate</th>
            </tr>
            </thead>
            <tbody>
            <#list offers as offer>
                <tr>
                    <td class="align-middle text-center" >${offer.creditName}</td>
                    <td class="align-middle text-center" >${offer.paymentAll}</td>
                    <td class="align-middle text-center" >${offer.bankName}</td>
                    <td class="align-middle text-center" >${offer.paymentMonth}</td>

                    <#list credits as credit>
                        <#if offer.creditName = credit.name>
                            <td class="align-middle text-center" >${credit.limit}</td>
                            <td class="align-middle text-center" >${credit.rate}</td>
                        </#if>
                    </#list>

                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div class="alert alert-primary col-sm-5" role="alert">
            There are no offers!
        </div>

    </#if>


</@c.page>