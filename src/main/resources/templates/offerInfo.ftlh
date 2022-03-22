<#import "parts/common.ftlh" as c>
<@c.page>
    <h3>Welcome to the ${bank.name}</h3>
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
    </form>
    </div>
</@c.page>