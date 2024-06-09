package org.example.analyzer;

import org.example.model.Company;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyAnalyzer {
    public static double getTotalCapitalOfHQInCH(List<Company> companies) {
        return companies
                .stream()
                .filter(company -> company.isHeadQuarter() && company.getCountry().equalsIgnoreCase("CH"))
                .mapToDouble(Company::getCapital)
                .sum();
    }

    public static List<String> getNameOfCompaniesInCHSortedByCapital(List<Company> companies) {
        return companies
                .stream()
                .filter(company -> company.getCountry().equalsIgnoreCase("CH"))
                .sorted(Comparator.comparingDouble(Company::getCapital).reversed())
                .map(Company::getName)
                .collect(Collectors.toList());
    }
}
