<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.master" AutoEventWireup="true"
    CodeFile="Default.aspx.cs" Inherits="_Default" %>

<asp:Content ID="HeaderContent" runat="server" ContentPlaceHolderID="HeadContent">
</asp:Content>
<asp:Content ID="BodyContent" runat="server" ContentPlaceHolderID="MainContent">
    <h2>
        Welcom<asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" 
            DataKeyNames="AccidentID" DataSourceID="SqlDataSource1" 
            EmptyDataText="There are no data records to display.">
            <Columns>
                <asp:BoundField DataField="AccidentID" HeaderText="AccidentID" ReadOnly="True" 
                    SortExpression="AccidentID" />
                <asp:BoundField DataField="AccidentDateTime" HeaderText="AccidentDateTime" 
                    SortExpression="AccidentDateTime" />
                <asp:BoundField DataField="AccidentLocation" HeaderText="AccidentLocation" 
                    SortExpression="AccidentLocation" />
                <asp:BoundField DataField="AccidentDetail" HeaderText="AccidentDetail" 
                    SortExpression="AccidentDetail" />
            </Columns>
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" 
            ConnectionString="<%$ ConnectionStrings:AccidentDBConnectionString1 %>" 
            DeleteCommand="DELETE FROM [AccidentData] WHERE [AccidentID] = @AccidentID" 
            InsertCommand="INSERT INTO [AccidentData] ([AccidentDateTime], [AccidentLocation], [AccidentDetail]) VALUES (@AccidentDateTime, @AccidentLocation, @AccidentDetail)" 
            ProviderName="<%$ ConnectionStrings:AccidentDBConnectionString1.ProviderName %>" 
            SelectCommand="SELECT [AccidentID], [AccidentDateTime], [AccidentLocation], [AccidentDetail] FROM [AccidentData]" 
            UpdateCommand="UPDATE [AccidentData] SET [AccidentDateTime] = @AccidentDateTime, [AccidentLocation] = @AccidentLocation, [AccidentDetail] = @AccidentDetail WHERE [AccidentID] = @AccidentID">
            <DeleteParameters>
                <asp:Parameter Name="AccidentID" Type="Int32" />
            </DeleteParameters>
            <InsertParameters>
                <asp:Parameter Name="AccidentDateTime" Type="DateTime" />
                <asp:Parameter Name="AccidentLocation" Type="String" />
                <asp:Parameter Name="AccidentDetail" Type="String" />
            </InsertParameters>
            <UpdateParameters>
                <asp:Parameter Name="AccidentDateTime" Type="DateTime" />
                <asp:Parameter Name="AccidentLocation" Type="String" />
                <asp:Parameter Name="AccidentDetail" Type="String" />
                <asp:Parameter Name="AccidentID" Type="Int32" />
            </UpdateParameters>
        </asp:SqlDataSource>
        e to ASP.NET!
    </h2>
    <p>
        To learn more about ASP.NET visit <a href="http://www.asp.net" title="ASP.NET Website">www.asp.net</a>.
    </p>
    <p>
        You can also find <a href="http://go.microsoft.com/fwlink/?LinkID=152368&amp;clcid=0x409"
            title="MSDN ASP.NET Docs">documentation on ASP.NET at MSDN</a>.




    </p>
</asp:Content>
