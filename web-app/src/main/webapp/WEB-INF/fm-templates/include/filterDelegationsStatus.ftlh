<!-- filterDelegationsStatus.ftlh -->

<#switch d.getDelegationStatus()>
    <#case "SAVED">
                    <tr class="info" style="border-bottom: 2pt solid black;">
        <#break>
    <#case "TOACCEPT">
                    <tr class="warning" style="border-bottom: 2pt solid black;">
        <#break>
    <#case "ACCEPTED">
                    <tr class="success" style="border-bottom: 2pt solid black;">
        <#break>
    <#case "DISCARTED">
                    <tr class="danger" style="border-bottom: 2pt solid black;">
        <#break>
    <#default>
                    <tr>
</#switch>
