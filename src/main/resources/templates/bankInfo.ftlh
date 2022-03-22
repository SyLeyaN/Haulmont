<#import "parts/common.ftlh" as c>

<@c.page>

<#list usrs as usr>
    <div class="align-middle text-center" >${usr.firstName} ${usr.midName} ${usr.lastName}</div>
</#list>

    <br><h5>Add new credit</h5>
    <div class="form-row align-items-center mt-3">
        <form action="${bank.id}/addCredit" method="post">
            <div class="col-auto my-1">
                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Name: </label>
                <div class="col-sm-5">
                    <input type="text" name="name" class="form-control"/>
                </div>
                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Limit (month): </label>
                <div class="col-sm-5">
                    <input type="float" name="limit" class="form-control"/>
                </div>
                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Rate: </label>
                <div class="col-sm-5">
                    <input type="float" name="rate" class="form-control"/>
                </div>
            </div>

            <button type="submit" class="btn btn-primary ml-2 mt-2 mb-2">Create</button>
        </form>
    </div>

    <div><h4>List of credits</h4></div>
    <#if creditSize!=0>
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="align-middle text-center" >Name</th>
                <th class="align-middle text-center" >Limit (month)</th>
                <th class="align-middle text-center" >Rate</th>
                <th class="align-middle text-center" >Offer</th>

                <#--                <th class="align-middle text-center" >Full info</th>-->
            </tr>
            </thead>
            <tbody>
            <#list credits as credit>
                <tr>
                    <td class="align-middle text-center" >${credit.name}</td>
                    <td class="align-middle text-center" >${credit.limit}</td>
                    <td class="align-middle text-center" >${credit.rate}</td>
                    <td class="align-middle text-center" ><a href="/banks/${bank.id}/${credit.id}">Take offer</a></td>
                    <td class="align-middle text-center" >
                        <form action="${bank.id}/deleteCredit" method="post">
                            <input type="hidden" name="name" value="${credit.name}"/>
                            <button type="submit" class="btn btn-outline-danger ml-2 mt-2" name="delete">Delete</button>
                        </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div class="alert alert-primary col-sm-5" role="alert">
            There are no credits!
        </div>

    </#if>

    <div><h4>List of clients</h4></div>
    <#if clientSize!=0>
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="align-middle text-center" >Name</th>
                <th class="align-middle text-center" >Passport</th>
                <th class="align-middle text-center" >Telephone</th>
                <th class="align-middle text-center" >Email</th>
            </tr>
            </thead>
            <tbody>
            <#list clients as client>
                <tr>
                    <td class="align-middle text-center" >${client.firstName} ${client.midName} ${client.lastName}</td>
                    <td class="align-middle text-center" >${client.passport}</td>
                    <td class="align-middle text-center" >${client.telephone}</td>
                    <td class="align-middle text-center" >${client.email}</td>

                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div class="alert alert-primary col-sm-5" role="alert">
            There are no clients!
        </div>

    </#if>

</@c.page>