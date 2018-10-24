<!-- filterDelegationsStatusOption.ftlh -->

<div class="col-md-2">

    <label>Status delegacji:</label><br>
    <select name="status" style="width: 100%;">

                            <#if statusOption == "">
                            <option selected value="">
                                wszystkie
                            </option>>
                            <#else >
                             <option value="">
                                 wszystkie
                             </option>>
                            </#if>

                            <#if statusOption == "TOACCEPT">
                            <option selected value="TOACCEPT">
                                do akceptacji
                            </option>>
                            <#else>
                            <option value="TOACCEPT">
                                do akceptacji
                            </option>>
                            </#if>

                            <#if statusOption == "ACCEPTED">
                            <option selected value="ACCEPTED">
                                zaakceptowano
                            </option>>
                            <#else>
                            <option value="ACCEPTED">
                                zaakceptowano
                            </option>>
                            </#if>

                            <#if statusOption == "DISCARTED">
                            <option selected value="DISCARTED">
                                brak akceptacji
                            </option>>
                            <#else>
                            <option value="DISCARTED">
                                brak akceptacji
                            </option>>
                            </#if>

    </select>
</div>