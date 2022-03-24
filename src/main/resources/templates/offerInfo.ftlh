<#import "parts/common.ftlh" as c>
<@c.page>

    <h3>Welcome to the ${bank.name} credit ${credit.name}</h3>

    <h4><font color="#dc143c">${messageError!""}</font></h4>

    <form method="post">
    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Rate: ${credit.rate}</label>
    </div>

    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Limit: ${credit.limit}</label>
    </div>

    <div class="col-auto my-1">
        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Total credit amount: </label>
        <div class="col-sm-5">
            <input type="float" name="sum" class="form-control"/>
        </div>

        <button type="submit" class="btn btn-primary ml-2 mt-2 mb-2" name="calculate">Calculate</button>
    </div>
    </form>

    <#if count != 0>
        <form action="${credit.id}/saveOffer" method="post">
            <div class="col-sm-5">
                <input type="text" name="passport" class="form-control"  placeholder="Enter client's passport">
                <input type="hidden" name="creditName" class="form-control"  value="${credit.name}">
                <input type="hidden" name="paymentAll" class="form-control"  value="${paymentAll}">
            </div>
            <button type="submit" class="btn btn-outline-danger ml-2 mt-2" name="delete">Accept</button>
        </form>
        <div class="col-auto my-1">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> All payment: ${paymentAll}</label>
        </div>
        <table class="table table-hover">

        <thead>
        <tr>
            <th class="align-middle text-center" >Month</th>
            <th class="align-middle text-center" >Month payment</th>
            <th class="align-middle text-center" >Percent</th>
            <th class="align-middle text-center" >Body </th>
            <th class="align-middle text-center" >Balance</th>
        </tr>
        </thead>
        <tbody>
        <#list paymentPercent as pP>
            <tr>
                <td class="align-middle text-center" >#{pP?index}</td>
                <td class="align-middle text-center" >${paymentMonth}</td>
                <td class="align-middle text-center" >${pP}</td>
                <td class="align-middle text-center" >${paymentBody[pP?index]}</td>
                <td class="align-middle text-center" >${balance[pP?index]}</td>
            </tr>
        </#list>
        </tbody>
        </table>

    </#if>

    <br><h5>Update credit's information</h5>
    <div class="form-group col-md-6">
        <form action="/banks/${bank.id}/${credit.id}/updateCredit" method="post">
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Name: </label>
            <div class="col-sm-5">
                <input type="text" name="creditName" value="${credit.name}"></label>
            </div>
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Rate: </label>
            <div class="col-sm-5">
                <input type="float" name="creditRate" value="${credit.rate}"></label>
            </div>
            <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Limit: </label>
            <div class="col-sm-5">
                <input type="float" name="creditLimit" value="${credit.limit}"></label>
            </div>
            <button type="submit" class="btn btn-primary ml-2 mt-2">Save</button>
        </form>
    </div>


</@c.page>