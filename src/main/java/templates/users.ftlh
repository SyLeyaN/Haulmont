<#import"parts/common.ftlh" as c>

<@c.page>
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
            <#list usrs as user>
                <tr>
                    <td class="align-middle text-center" >${user.firstname} ${user.midname} ${user.lastname}</td>
                    <td class="align-middle text-center" >${user.passport}</td>
                    <td class="align-middle text-center" >${user.telephone}</td>
                    <td class="align-middle text-center" >${user.email}</td>
                    <td class="align-middle text-center" ><a href="/${user.id}">Banks and offers</a></td>
                    <td class="align-middle text-center" >
                                <form action="/delete" method="post">
                                    <input type="hidden" name="game" value="${user.name}"/>
                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
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