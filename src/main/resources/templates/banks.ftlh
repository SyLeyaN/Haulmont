<#import "parts/common.ftlh" as c>

<@c.page>
    <h4><font color="#dc143c">${messageError!""}</font></h4>
    <br><h5>Add new bank</h5>
    <div class="form-row align-items-center mt-3">
        <form method="post">
            <#--    <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->

            <div class="col-auto my-1">
                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect"> Name: </label>
                <div class="col-sm-5">
                    <input type="text" name="name" class="form-control"/>
                </div>
            </div>

            <button type="submit" class="btn btn-primary ml-2 mt-2 mb-2">Create</button>
        </form>
    </div>

    <div><h4>List of banks</h4></div>
    <#if bankSize!=0>
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="align-middle text-center" >Name</th>
                <th class="align-middle text-center" >Full info</th>
            </tr>
            </thead>
            <tbody>
            <#list banks as bank>
                <tr>
                    <td class="align-middle text-center" >${bank.name}</td>
                    <td class="align-middle text-center" ><a href="/banks/${bank.id}">Clients and credits</a></td>
                    <td class="align-middle text-center" >
                        <form action="banks/delete" method="post">
                            <input type="hidden" name="name" value="${bank.name}"/>
                            <button type="submit" class="btn btn-outline-danger ml-2 mt-2" name="delete">Delete</button>
                        </form>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <div class="alert alert-primary col-sm-5" role="alert">
            There are no banks!
        </div>

    </#if>
</@c.page>